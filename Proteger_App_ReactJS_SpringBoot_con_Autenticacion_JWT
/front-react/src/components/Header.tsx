export default function Header(props: any) {
    return (
        <header className='App-header'>
            <img src={props.logoSrcr} className='App-logo' alt='logo' />
            <h1 className='App-title'>{props.pageTitle}</h1>
        </header>
    )
}