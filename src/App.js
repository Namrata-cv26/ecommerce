import logo from './logo.svg';
import './App.css';
import Navigation from './customer/components/Navigation/Navigation.jsx';
import HomePage from './customer/Pages/HomePage/HomePage.jsx';
import Footer from './customer/components/Footer/Footer.jsx';
import Product from './customer/components/Product/Product.jsx';
function App() {
  return (
    <div className="">
    <Navigation/>
    <div>
      {/*<HomePage/>*/}
      <Product/>
    </div>
    <Footer/>
    </div>
  );
}

export default App;
