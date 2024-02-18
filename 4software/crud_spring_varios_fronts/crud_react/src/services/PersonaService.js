import axios from "axios";

export class PersonaService {
  baseUrl = "http://localhost:8082/api/v1/";

  getAll() {
    return axios
      .get(this.baseUrl + "all")
      .then((res) => {
        if (res.data) {
          return res.data;
        } else {
          return null;
        }
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
        throw error;
      });
  }

  save(persona) {
    return axios.post(this.baseUrl + "save", persona).then((res) => res.data);
  }
}
