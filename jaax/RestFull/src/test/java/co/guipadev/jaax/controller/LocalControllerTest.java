package co.guipadev.jaax.controller;

import co.guipadev.jaax.entity.Local;
import co.guipadev.jaax.service.LocalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(LocalController.class)
class LocalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocalServiceImpl localService;

    private Local local;
    @BeforeEach
    void setUp() {
        // Información que esta en BD
        local =
                Local.builder()
                        .name("Almacenes exito")
                        .floor("Granos")
                        .code("ex001")
                        .build();
    }

    @Test
    public void saveLocal() throws Exception {
        Local postLocal = Local.builder()
                .name("Almacenes exito")
                .floor("Granos")
                .code("ex001")
                .build();
        // Retorna lo que contiene la BD
        Mockito.when(localService.saveLocal(postLocal)).thenReturn(local);
        // Peticion POSST enviar JSON contiene misma info del Objc
        mockMvc.perform(post("/saveLocal").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"name\": \"Restaurante Español\",\n" +
                        "\"floor\": \"Paeya\",\n" +
                        "\"code\": \"c003\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    public void findLocalById() throws Exception {
        // Simule y lance lo de BD
        Mockito.when(localService.findLocalById(1L)).thenReturn(local);
        // Peticion GET controlador con URL, recibir JSON, status y espera recibir un Name
        mockMvc.perform(get("/findLocalById/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(local.getName()));
    }
}