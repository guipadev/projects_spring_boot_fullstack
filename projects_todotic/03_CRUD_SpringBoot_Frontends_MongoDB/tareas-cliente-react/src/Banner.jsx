import img from './assets/task.svg'

const Banner = () => {
    return ( 
        <div className="rounded shadow p-5 mt-5 d-flex">
            <img src={img} alt="logo" width="250" />
            <div>
                <h3 className='text-primary'>Bienvenido a Tareas</h3>
                <h5 className='text-secondary'>
                    Con esta aplicación podras consultar, crear, actualizar y eliminar tareas
                </h5>
                <hr/>
                <p className='text-muted'>
                    Esta aplicación fue desarrollada con spring boot, ReactJS y MongoDB.
                </p>
            </div>
        </div> 
    );
}
 
export default Banner;