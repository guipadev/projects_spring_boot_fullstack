import axios from "axios";

export class PersonaService {
  baseUrl = "http://localhost:8082/api/v1/";

  getAll() {
    return axios
      .get(this.baseUrl + "all")
      .then((res) => {
        if (res.data) {
          //console.log("Respuesta recibida:", res.data);
          return res.data;
        } else {
          //console.warn("La respuesta está vacía.");
          return null;
        }
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
        throw error;
      });
  }
}
