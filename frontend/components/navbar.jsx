import Link from 'next/link'
import style from './styles/navbar.module.css'

export default function Navbar() {

    return(

        <nav className={style.nav}>

            <div className={style.titulo}>
            
 
                <img src="/logo_f.png" alt="Logo" className={style.logo} />
            </div>

            <div className={style.navegacion}>
                <ul>
                    <li> <Link href="/home"> Inicio </Link> </li>

                    <li> <Link href="/giro"> Realizar Giro </Link> </li>


                    <li> <Link href="/balance"> Realizar Balance </Link> </li>
                </ul>
            </div>
            <div className={style.derecha} />  
    

        </nav>
    )

}