import { useEffect, useState } from "react";

/* eslint-disable react/prop-types */
function HeaderComponent({ selected, setSelected }) {
  const [category, setCatagory] = useState([]);

  useEffect(() => {
    fetch("https://fakestoreapi.com/products/categories")
      .then((res) => res.json())
      .then((json) => setCatagory(json));
  }, []);

  return (
    <div className={"header-items"}>
      {category.map((category) => (
        <h3
          className={
            "header-item " +
            (selected === category ? "header-item-selected" : "")
          }
          onClick={() => {
            setSelected(category);
          }}
          key={category}
        >
          {category}
        </h3>
      ))}
    </div>
  );
}

export default HeaderComponent;
