import styled from "styled-components";

// 나중에 필요하면 사용
const Option = ({ text, onClick, click }) => {
  return (
    <>
      <Btn click={click} onClick={onClick}>
        {text}
      </Btn>
    </>
  );
};

const Btn = styled.button`
  width: 600px;
  height: 54px;
  border-radius: 22px;
  border: 1px solid #7e7e7e;
  font-size: 18px;
  background-color: ${(props) => (props.click ? "#6582FC" : "white")};
  margin-top: 2rem;
  cursor: pointer;
`;

export default Option;
