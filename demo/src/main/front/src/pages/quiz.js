import styled from "styled-components";
import { ReactComponent as logo } from "../images/slang.svg";
import { useNavigate } from "react-router-dom";
import Questions from "../utils/Questions";
import QuizContent from "../components/quizContent";
import { useState } from "react";

const Quiz = () => {
  let [count, setCount] = useState(0); // 문제 번호
  const navigate = useNavigate();

  let question = Questions.Q1[count];
  const isLastQuestion = count === Questions.Q1.length - 1;

  const handleNavigateHome = () => {
    navigate("/home");
  };

  const handleCountPlus = () => {
    if (isLastQuestion) {
      navigate("/quizResult");
    } else if (count < Questions.Q1.length - 1) {
      setCount(count + 1);
    }
  };

  const handleCountMinus = () => {
    if (count > 0) {
      setCount(count - 1);
    }
  };

  return (
    <>
      <Logo onClick={handleNavigateHome} />
      <QuizContent q={question} idx={count + 1} />
      <Center>
        <BtnContainer>
          <PrevBtn onClick={handleCountMinus}>이전 문제</PrevBtn>
          <NextBtn onClick={handleCountPlus}>
            {isLastQuestion ? "제출하기" : "다음 문제"}
          </NextBtn>
        </BtnContainer>
      </Center>
    </>
  );
};

const Center = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
`;

const Logo = styled(logo)`
  width: 5rem;
  margin-left: 2rem;
  cursor: pointer;
`;

const BtnContainer = styled.div``;

const PrevBtn = styled.button`
  background-color: #bac7ff;
  width: 160px;
  height: 50px;
  color: white;
  border-radius: 12px;
  border: none;
  font-size: 16px;
  font-weight: 600;
  margin-top: 3rem;
  cursor: pointer;
`;

const NextBtn = styled(PrevBtn)`
  background-color: #6582fc;
  margin-left: 3rem;
`;

export default Quiz;
