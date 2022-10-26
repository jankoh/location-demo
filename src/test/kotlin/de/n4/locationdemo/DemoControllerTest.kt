package de.n4.locationdemo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class DemoControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `getLocation() should not except`() {
        mockMvc.perform(
            get("/api/geo")
        ).andExpect(status().isOk)
    }

}