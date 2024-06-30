import { useEffect, useState } from "react";
import "./App.css";
import HeaderComponent from "./Components/HeaderComponent";
import ProductsComponent from "./Components/ProductsComponent";
import Product from "./Components/Product";
import LogoComponent from "./Components/LogoComponent";
import LoadingComponent from "./Components/LoadingComponent";

function App() {
  const [selected, setSelected] = useState("");
  const [data, setData] = useState([]);
  const [loader, setLoader] = useState(false);

  useEffect(() => {
    setLoader(true);
    fetch("https://fakestoreapi.com/products")
      .then((res) => res.json())
      .then((json) => {
        setData(json);
        setLoader(false);
      });
  }, []);

  if (loader)
    return (
      <div className="App">
        <div className="header">
          <LogoComponent setSelected={setSelected} />
          <HeaderComponent selected={selected} setSelected={setSelected} />
        </div>
        <LoadingComponent />
      </div>
    );
  else
    return (
      <div className="App">
        <div className="header">
          <LogoComponent setSelected={setSelected} />
          <HeaderComponent selected={selected} setSelected={setSelected} />
        </div>
        <div className="products">
          {selected === "" ? (
            data.map((product) => (
              <Product key={product.id} product={product} />
            ))
          ) : (
            <ProductsComponent selected={selected} />
          )}
        </div>
      </div>
    );
}

export default App;
