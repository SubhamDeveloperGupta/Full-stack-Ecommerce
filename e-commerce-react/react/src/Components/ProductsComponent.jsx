import { useEffect, useState } from "react";
import Product from "./Product";
import LoadingComponent from "./LoadingComponent";

/* eslint-disable react/prop-types */
function ProductsComponent({ selected }) {
  const [products, setProducts] = useState([]);
  const [loader, setLoader] = useState(false);

  useEffect(() => {
    setLoader(true);
    fetch(`https://fakestoreapi.com/products/category/${selected}`)
      .then((res) => res.json())
      .then((json) => {
        setProducts(json);
        setLoader(false);
        // console.log(json);
      });
  }, [selected]);

  if (loader) return <LoadingComponent />;
  else
    return (
      <div className="products">
        {products.map((product) => (
          // console.log(product);
          <Product key={product.id} product={product} />
        ))}
      </div>
    );
}

export default ProductsComponent;
