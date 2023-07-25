import styled from "styled-components";
import { useState, useEffect } from "react";

const QuizContent = ({ q, idx }) => {
  const [click, setClick] = useState(0);
  let progress = idx / 5;

  useEffect(() => {
    setClick(0);
  }, [q]);

  return (
    <>
      {/* 가운데 정렬 안되서 애먹었는데 width 지정하고 margin: auto 주니까 됐다!! */}
      <StatusContainer>
        <Status1 percent={progress} />
        <Status2 />
      </StatusContainer>
      <Container>
        <Q>{q}</Q>
        {/* 아래도 컴포넌트화하기 */}
        <Btn onClick={() => setClick(1)} click={click === 1 ? "true" : "false"}>
          추구미
        </Btn>
        <Btn onClick={() => setClick(2)} click={click === 2 ? "true" : "false"}>
          중꺽마
        </Btn>
        <Btn onClick={() => setClick(3)} click={click === 3 ? "true" : "false"}>
          ㄱㅂㅈㄱ
        </Btn>
        <Btn onClick={() => setClick(4)} click={click === 4 ? "true" : "false"}>
          몸테크
        </Btn>
        <Btn onClick={() => setClick(5)} click={click === 5 ? "true" : "false"}>
          스라벨
        </Btn>
      </Container>
    </>
  );
};

const StatusContainer = styled.div`
  display: flex;
  margin: 0 auto;
  width: 710px;
`;

const Btn = styled.button`
  width: 600px;
  height: 54px;
  border-radius: 22px;
  border: 1px solid #7e7e7e;
  font-size: 18px;
  background-color: ${(props) =>
    props.click === "true" ? "#6582FC" : "white"};
  margin-top: 2rem;
  cursor: pointer;
`;

const Status1 = styled.div`
  width: ${(props) => props.percent * 710}px;
  height: 10px;
  background-color: #6582fc;
  border-radius: 22px;
`;

const Status2 = styled.div`
  position: absolute;
  z-index: -1;
  width: 710px;
  height: 10px;
  background-color: #d9d9d9;
  border-radius: 22px;
`;

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const Q = styled.h1`
  font-size: 25px;
  margin-bottom: 1rem;
  width: 50rem;
  text-align: center;
`;

export default QuizContent;
