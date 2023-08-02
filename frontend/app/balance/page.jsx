'use client'
import style from './page.module.css';
import { useState } from 'react';
import ResumenService from '../Services/Resumen';

export default function Balance() {
    const [fechaInicial, setFechaInicial] = useState("");
    const [fechaFinal, setFechaFinal] = useState("");
    const [resumenes, setResumenes] = useState([]);

    const cambioFechaInicial = (e) => {
        setFechaInicial(e.target.value);
    }
    const cambioFechaFinal = (e) => {
        setFechaFinal(e.target.value);
    }

    const generarYmostrar = (e) => {

        const fechas = {
            fechaInicial: fechaInicial,
            fechaFinal: fechaFinal
        }
        ResumenService.crearResumen(fechas).then((res) => {
            ResumenService.mostrarResumen().then((res2) => {
                setResumenes(res2.data);
                console.log(resumenes);
            })
        })

    }


    return (


        <div className={style.pageContainer}>
            <div className={style.datePanel}>
                <div className={style.dateContainer}>
                    <label className={style.dateLabel}>Fecha Inicial:</label>
                    <input type="date" value={fechaInicial} onChange={cambioFechaInicial} className={style.dateInput} />
                    <label className={style.dateLabel}>Fecha Final:</label>
                    <input type="date" value={fechaFinal} onChange={cambioFechaFinal} className={style.dateInput} />
                    <button onClick={generarYmostrar} className={style.dateButton}>Enviar Fechas</button>
                </div>
            </div>



            <table className={style.table}>
                <thead>
                    <tr>
                        <th className={style.header}>Nro</th>
                        <th className={style.header}>Fecha</th>
                        <th className={style.header}>Tipo Doc</th>
                        <th className={style.header}>Num Doc</th>
                        <th className={style.header}>Motivo</th>
                        <th className={style.header}>Ingreso</th>
                        <th className={style.header}>Salida</th>
                        <th className={style.header}>Saldo</th>
                    </tr>
                </thead>
                <tbody className={style.tbodyStyled}>
                    {resumenes.map((resumen, index) => (
                        <tr key={index}>
                            <td>{index + 1}</td>
                            <td>{resumen.fecha}</td>
                            <td>{resumen.tipoDoc}</td>
                            <td>{resumen.numDoc}</td>
                            <td>{resumen.motivo}</td>
                            <td>{resumen.tipo == "Entrada" ? resumen.monto : 0} </td>
                            <td>{resumen.tipo == "Salida" ? resumen.monto : 0} </td>
                            <td>{resumen.saldo}</td>
                        </tr>
                    ))}
                </tbody>

            </table>
        </div>
    );
}
