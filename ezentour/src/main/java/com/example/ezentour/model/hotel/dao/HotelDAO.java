package com.example.ezentour.model.hotel.dao;

import java.util.List;

import com.example.ezentour.model.hotel.dto.HotelDTO;

public interface HotelDAO {
	public HotelDTO viewHotel(int h_no);
	public void insertHotel(HotelDTO hDto);
	public List<HotelDTO> listHotel(String h_m_id); 
	public List<HotelDTO> listHotel(); 
	public void updateHotel(HotelDTO hDto);
	public void deleteHotel(int h_no);
	public List<HotelDTO> Hotel_approve(String h_approve);
	public void updateHotel_approve(int h_no);
	public HotelDTO selectHotel_room(int h_no);
	public HotelDTO selectHotel_room(int h_no, String h_address, String h_type);
	public List<HotelDTO> dateListHotel(String h_address, int h_room, String h_type); 
	public List<HotelDTO> priceSearchList(int minPrice, int maxPrice);
	public HotelDTO selectHotel_roomPrice(int h_no,String h_type); 
}
