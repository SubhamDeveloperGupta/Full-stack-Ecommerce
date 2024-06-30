/* eslint-disable react/prop-types */
function Product({ product }) {
  return (
    <div className="product">
      <img className="image" src={product.image} alt={product.title} />
      <div className="title">{product.title}</div>
      <h3>$ {product.price}</h3>
    </div>
  );
}

export default Product;
