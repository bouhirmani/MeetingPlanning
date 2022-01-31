package fr.canal.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import fr.canal.planner.controller.BookingController;
import fr.canal.planner.dto.RoomDto;
import fr.canal.planner.service.RoomService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookingController.class)
public class BookingControllerTests {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	RoomService roomService;
	
	@Test
	public void getRooms() throws Exception {

		List<RoomDto> rooms = new ArrayList<RoomDto>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		RoomDto room1 = new RoomDto("E1001",29,LocalDateTime.parse("2022-01-31 09:00", formatter));
		RoomDto room2 = new RoomDto("E1002",15,LocalDateTime.parse("2022-01-31 09:00", formatter));
		rooms.add(room1);
		rooms.add(room2);

		Mockito.when(roomService.findAll()).thenReturn(rooms);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rooms").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{'name':'E1001','capacity':29,'lastReservation':'2022-01-31T09:00:00','equipments':[]},{'name':'E1002','capacity':15,'lastReservation':'2022-01-31T09:00:00','equipments':[]}]";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	@Test
	public void createRoom() throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		RoomDto mockRoom = new RoomDto("E1001",29,LocalDateTime.parse("2022-01-31 09:00", formatter));

		Mockito.when(
				roomService.create(Mockito.any(RoomDto.class))).thenReturn(mockRoom);

		String exampleRoomJson = "{\"name\":\"E1001\",\"capacity\":29,\"lastReservation\":\"2022-01-31T09:00:00\",\"equipments\":[]}";

		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders.post("/rooms").accept(MediaType.APPLICATION_JSON)
				.content(exampleRoomJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

	}

}
