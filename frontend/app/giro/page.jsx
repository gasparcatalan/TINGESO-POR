'use client'
import style from './page.module.css';
import { useState } from 'react';
import EntradaService from '../Services/Entrada';
import SalidaService from '../Services/Salida';
import { redirect } from 'next/dist/server/api-utils';
import { useRouter } from 'next/navigation';


export default function Entrada() {

    //Estados para todas las variables del formulario
    const [documento, setDocumento] = useState("");
    const [tipo_documento, setTipo_documento] = useState("boleta");
    const [tipo_giro, setTipo_giro] = useState("entrada");
    const [monto, setMonto] = useState(0);
    const [motivo, setMotivo] = useState("");
    const router = useRouter();

    const cambioDocumento = (e) => {
        setDocumento(e.target.value);
        console.log(documento);
    }

    const cambioTipo_documento = (e) => {
        setTipo_documento(e.target.value);
    }

    const cambioTipo_giro = (e) => {
        setTipo_giro(e.target.value);
    }
    const cambioMonto = (e) => {
        setMonto(e.target.value);
    }
    const cambioMotivo = (e) => {
        setMotivo(e.target.value);
    }
    const enviarFormulario = (e) => {
        e.preventDefault();
        if(monto == 0){
            alert("El monto no puede ser 0");
            return;
        }
        if(documento == ""){
            alert("El documento no puede estar vacio");
            return;
        }

        if(tipo_giro == "entrada"){
            //Creamos JSON para enviar a la API
            const entrada = {
                numDoc: documento,
                tipoDoc: tipo_documento,
                monto: monto,
                motivo: motivo,
                fecha: new Date()
            }
            
            try{
            EntradaService.crearEntrada(entrada);
            alert("ENTRADA GENERADA CON EXITO");
            router.push("/home");
            return;}
            catch(error){
                alert("ERROR AL GENERAR ENTRADA");
                return;
            }
        }
        if(tipo_giro == "salida"){
            //Creamos JSON para enviar a la API
            const salida = {
                numDoc: documento,
                tipoDoc: tipo_documento,
                monto: monto,
                motivo: motivo,
                fecha: new Date()
            }
            try{
            SalidaService.crearSalida(salida);
            alert("SALIDA GENERADA CON EXITO");
            router.push("/home");
            return;}
            catch(error){
                alert("ERROR AL GENERAR SALIDA");
                return;
            }
        }

        
    
    }

   
    return (
        <div className={style.body}>
            <form className={style.form} onSubmit={enviarFormulario} >
                <div>
                    <label className={style.label} htmlFor="documento">Número de Documento:</label>
                    <input className={style.input} onChange={cambioDocumento} type="text" id="documento" name="documento" required />
                </div>
                <div>
                    <label className={style.label} htmlFor="tipo_documento">Tipo de Documento:</label>
                    <select className={style.select} onChange={cambioTipo_documento}  id="tipo_documento" name="tipo_documento" required>
                        <option value="boleta">Boleta</option>
                        <option value="factura">Factura</option>
                    </select>
                </div>
                <div>
                    <label className={style.label} htmlFor="tipo_giro">Tipo de Giro:</label>
                    <select className={style.select} onChange={cambioTipo_giro} id="tipo_giro" name="tipo_giro" required>
                        <option value="entrada">Entrada</option>
                        <option value="salida">Salida</option>
                    </select>
                </div>
                <div>
                    <label className={style.label} htmlFor="monto">Monto de Dinero:</label>
                    <input className={style.input} onChange={cambioMonto} type="number" id="monto" name="monto" step="100" required />
                </div>
                <div>
                    <label className={style.label} htmlFor="motivo">Motivo del Depósito:</label>
                    <textarea className={style.textarea} onChange={cambioMotivo} id="motivo" name="motivo" rows="4" required></textarea>
                </div>
                <input className={style.input}  type="submit" value="Enviar" />
            </form>
        </div>
    )
}
