package hr.tvz.ilisinovic.hardwareapp.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.ilisinovic.hardwareapp.model.HardwareCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.
        SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class HardwareControllerTest {
    @Autowired
    private MockMvc mockMvc;


    private ObjectMapper objectMapper=new ObjectMapper();

    @Test
    void getAllHardware() throws Exception {

        this.mockMvc.perform(
                        get("/hardware")
                                .with(user("admin")
                                        .password("admin")
                                        .roles("ADMIN")
                                )
                                .with(csrf())
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

    }

    @Test
    void getHardwareByCode() throws Exception {
        this.mockMvc.perform(
                        get("/hardware/code11")
                                .with(user("admin")
                                        .password("admin")
                                        .roles("ADMIN")
                                )
                                .with(csrf())
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.code").value("code11"))
                .andExpect(jsonPath("$.name").value("pio 3fk"))
                .andExpect(jsonPath("$.price").value(44.8));
    }

    @Test
    void getHardwareByCodeNone() throws Exception {
        this.mockMvc.perform(
                        get("/hardware/xxxxxx")
                                .with(user("admin")
                                        .password("admin")
                                        .roles("ADMIN")
                                )
                                .with(csrf())
                )
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void save() throws Exception {
        HardwareCommand hardwareCommand=new HardwareCommand("code99","exon",334.5,"GPU",4);

        this.mockMvc.perform(
                        post("/hardware")
                                .with(user("admin")
                                        .password("admin")
                                        .roles("ADMIN")
                                )
                                .with(csrf())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(hardwareCommand))
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.code").value(hardwareCommand.getCode()))
                .andExpect(jsonPath("$.name").value(hardwareCommand.getName()))
                .andExpect(jsonPath("$.price").value(hardwareCommand.getPrice()));
    }

    @Test
    @Transactional
    void update() throws Exception {
        HardwareCommand hardwareCommand=new HardwareCommand("code10","exon",334.5,"GPU",4);

        this.mockMvc.perform(
                        put("/hardware/code10")
                                .with(user("admin")
                                        .password("admin")
                                        .roles("ADMIN")
                                )
                                .with(csrf())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(hardwareCommand))
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.code").value(hardwareCommand.getCode()))
                .andExpect(jsonPath("$.name").value(hardwareCommand.getName()))
                .andExpect(jsonPath("$.price").value(hardwareCommand.getPrice()));
    }
    @Test
    @Transactional
    void updateHardwareByCodeNone() throws Exception {
        HardwareCommand hardwareCommand = new HardwareCommand("xxxxxx", "exon", 334.5, "GPU", 4);
        this.mockMvc.perform(
                        get("/hardware/xxxxxx")
                                .with(user("admin")
                                        .password("admin")
                                        .roles("ADMIN")
                                )
                                .with(csrf())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(hardwareCommand))
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound());
    }
}