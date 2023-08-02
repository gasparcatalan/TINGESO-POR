import axios from "axios";

const mi_url = "http://localhost:8080/entrada";

    class Entrada{

        crearEntrada(entrada){
            return axios.post(mi_url+ "/crear", entrada);
        }
    }

    export default new Entrada();