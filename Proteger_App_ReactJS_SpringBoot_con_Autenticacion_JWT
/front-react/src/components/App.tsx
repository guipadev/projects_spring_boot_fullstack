import './App.css'
import logo from '../assets/react.svg'
import Header from './Header'
import AppContent from './AppContent'

function App() {

    return (
        <div>
            <Header pageTitle="Frontend authenticated with JWT" logoSrcr={logo} />
            <div className='container-fluid'>
                <div className='row'>
                    <div className='col'>
                        <AppContent />
                    </div>
                </div>
            </div>
        </div>
            
    )
}

export default App