/* eslint-disable react/prop-types */
function LogoComponent({ setSelected }) {
  function changeSelector() {
    setSelected("");
  }

  return (
    <div className="logo" onClick={() => changeSelector()}>
      My-Store
    </div>
  );
}

export default LogoComponent;
