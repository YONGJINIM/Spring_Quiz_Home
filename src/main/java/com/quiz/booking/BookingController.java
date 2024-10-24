package com.quiz.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
    
    // BookingBO를 Autowired를 통해 주입받음, 이 BO는 비즈니스 로직을 처리함
    @Autowired
    private BookingBO bookingBO;

    // 1) 예약 목록 화면
    @GetMapping("/booking-list-view")
    public String bookingListView(Model model) { // Model 객체를 파라미터로 선언하여 View에 데이터 전달 가능
        
        // DB에서 예약 목록을 조회
        List<Booking> bookingList = bookingBO.getBookingList();
        
        // 조회한 예약 목록을 Model에 저장하여 View에서 사용 가능하도록 함
        model.addAttribute("bookingList", bookingList);
        
        // 예약 목록을 보여줄 View 파일의 이름을 반환 (resources/templates/booking/bookingList.html)
        return "booking/bookingList"; 
    }
    
    // 2) 예약 삭제 기능 - AJAX 요청 처리
    @ResponseBody
    @DeleteMapping("/delete-booking")
    public Map<String, Object> deleteBooking(
            @RequestParam("id") int id) { // 삭제할 예약의 ID를 파라미터로 받음
        
        // DB에서 해당 ID의 예약 삭제
        int rowCount = bookingBO.deleteBookingById(id);
        
        // 결과를 저장할 Map 객체 생성
        Map<String, Object> result = new HashMap<>();
        
        // 삭제된 행(row)이 존재하면 성공 코드와 메시지 반환
        if (rowCount > 0) {
            result.put("code", 200);
            result.put("result", "성공");
        } else { // 삭제할 대상이 없으면 에러 코드와 메시지 반환
            result.put("code", 500);
            result.put("error_message", "삭제할 대상이 없습니다.");
        }
        // JSON 형태로 응답
        return result;
    }
    
    // 3) 예약하기 화면
    @GetMapping("/make-booking-view")
    public String makeBookingView() {
        // 예약하기 폼을 보여줄 View 파일의 이름을 반환 (resources/templates/booking/makeBooking.html)
        return "booking/makeBooking";
    }
    
    // 4) 예약 추가 기능 - AJAX 요청 처리
    @ResponseBody
    @PostMapping("/make-booking")
    public Map<String, Object> makeBooking(
            @RequestParam("name") String name, // 예약자 이름
            @RequestParam("date") LocalDate date, // 예약 날짜
            @RequestParam("day") int day, // 예약 일수
            @RequestParam("headcount") int headcount, // 예약 인원
            @RequestParam("phoneNumber") String phoneNumber) { // 예약자 전화번호
        
        // DB에 새로운 예약 정보를 추가
        bookingBO.addBooking(name, date, day, headcount, phoneNumber);
        
        // 결과를 저장할 Map 객체 생성
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200); // 성공 코드
        result.put("result", "성공"); // 성공 메시지
        
        // JSON 형태로 응답
        return result;
    }
    
    // 5) 예약 조회 화면
    @GetMapping("/check-booking-view")
    public String checkBookingView() {
        // 예약 조회 폼을 보여줄 View 파일의 이름을 반환 (resources/templates/booking/checkBooking.html)
        return "booking/checkBooking";
    }
    
    // 6) 예약 조회 기능 - AJAX 요청 처리
    @ResponseBody // 모델이 없다. 
    @PostMapping("/check-booking")
    public Map<String, Object> checkBooking(
            @RequestParam("name") String name, // 예약자 이름
            @RequestParam("phoneNumber") String phoneNumber) { // 예약자 전화번호
        
        // DB에서 예약자 이름과 전화번호로 가장 최근 예약 정보 조회
        Booking booking = bookingBO.getLatestBookingByNamePhoneNumber(name, phoneNumber);
        
        // 결과를 저장할 Map 객체 생성
        Map<String, Object> result = new HashMap<>();
        
        // 조회된 예약 정보가 없으면 에러 코드와 메시지 반환
        if(booking == null) {
            result.put("code", 500);
            result.put("error_message", "조회된 정보가 없습니다.");
        } else { // 예약 정보가 있으면 성공 코드와 조회된 예약 정보 반환
            result.put("code", 200);
            result.put("booking", booking); // 조회된 예약 정보를 포함
        }    
        // JSON 형태로 응답
        return result;
    }
}
