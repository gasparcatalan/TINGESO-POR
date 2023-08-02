import axios from "axios";

const mi_url = "http://localhost:8080/salida";

class Salida{
    crearSalida(salida){
        return axios.post(mi_url+ "/crear", salida);
    }
}


export default new Salida();

