import axios from "axios";

const mi_url = "http://localhost:8080/resumen";


    class Resumen{

        crearResumen(fechas){
            return axios.post(mi_url+ "/generar", fechas,{
                headers: { "Content-Type": "multipart/form-data" }
            });
        }

        mostrarResumen(){
            return axios.get(mi_url);
        }
    }

    export default new Resumen();