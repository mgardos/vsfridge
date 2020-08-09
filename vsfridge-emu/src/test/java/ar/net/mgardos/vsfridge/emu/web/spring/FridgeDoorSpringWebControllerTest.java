package ar.net.mgardos.vsfridge.emu.web.spring;

import ar.net.mgardos.vsfridge.assembly.broker.FridgeBroker;
import ar.net.mgardos.vsfridge.assembly.broker.base.usage.BaseOpenDoorUsage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {FridgeSpringWebEmulation.class})
@ActiveProfiles("test")
@AutoConfigureMockMvc
class FridgeDoorSpringWebControllerTest {
	@Autowired
	private FridgeBroker fridgeBroker;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
	}

	@Test
	void testOpenWhenFridgeAndDoorExistsThenOpen() throws Exception {
		String fridgeId = "abc123";
		String doorId = "abc123";
		String path = String.format("/fridge/%s/door/%s/open", fridgeId, doorId);

		mockMvc.perform(patch(path)).andExpect(status().is2xxSuccessful());

		verify(fridgeBroker, times(1)).useFridge(eq(fridgeId), isA(BaseOpenDoorUsage.class));
	}

	@Test
	void testOpenWhenFridgeNotExistsThenException() throws Exception {
		String fridgeId = "";
		String doorId = "abc123";
		String path = String.format("/fridge/%s/door/%s/open", fridgeId, doorId);

		mockMvc.perform(patch(path)).andExpect(status().is4xxClientError());
	}

	@Test
	void testOpenWhenFridgeExistsAndDoorNotExistsThenException() throws Exception {
		String fridgeId = "abc123";
		String doorId = "";
		String path = String.format("/fridge/%s/door/%s/open", fridgeId, doorId);

		mockMvc.perform(patch(path)).andExpect(status().is4xxClientError());
	}

	@Test
	void testCloseWhenFridgeAndDoorExistsThenClose() throws Exception {
		String fridgeId = "abc123";
		String doorId = "abc123";
		String path = String.format("/fridge/%s/door/%s/close", fridgeId, doorId);

		mockMvc.perform(patch(path)).andExpect(status().is2xxSuccessful());
	}

	@Test
	void testCloseWhenFridgeNotExistsThenException() throws Exception {
		String fridgeId = "";
		String doorId = "abc123";
		String path = String.format("/fridge/%s/door/%s/close", fridgeId, doorId);

		mockMvc.perform(patch(path)).andExpect(status().is4xxClientError());
	}

	@Test
	void testCloseWhenFridgeExistsAndDoorNotExistsThenException() throws Exception {
		String fridgeId = "abc123";
		String doorId = "";
		String path = String.format("/fridge/%s/door/%s/close", fridgeId, doorId);

		mockMvc.perform(patch(path)).andExpect(status().is4xxClientError());
	}
}