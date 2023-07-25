import styled from "styled-components";
import Header from "../components/header";
import { useNavigate } from "react-router-dom";
import { useState } from "react";

const QuizResults = () => {
  const navigate = useNavigate();

  const [correctAnswers, setCorrectAnswers] = useState(0);
  const totalQuestions = 5;
  const maxScore = 100;

  const quizScore = (correctAnswers / totalQuestions) * maxScore;

  const [quizResults, setQuizResults] = useState([
    { questionNumber: 1, isCorrect: true },
    { questionNumber: 2, isCorrect: false },
    { questionNumber: 3, isCorrect: true },
    { questionNumber: 4, isCorrect: true },
    { questionNumber: 5, isCorrect: false },
  ]);

  const handleRestartQuiz = () => {
    navigate("/quiz");
  };

  const handleNavigateHome = () => {
    navigate("/home");
  };

  const handleShareResults = () => {
    // 공유 기능 추가 예정
  };

  return (
      <Container>
        <HeaderContainer>
        <Header />
        </HeaderContainer>
        <Content>
        <Title>퀴즈 결과</Title>
        <Score>당신의 점수는 {quizScore}점 입니다.</Score>
        <Answers>
          {quizResults.map((result, index) => (
            <AnswerItem key={index}>
                <QuestionNumber>{result.questionNumber}번:</QuestionNumber>
                <AnswerResult>{result.isCorrect ? "O" : "X"}</AnswerResult>
            </AnswerItem>
           ))}
        </Answers>
        <ButtonContainer>
          <Button onClick={handleRestartQuiz}>퀴즈 다시 풀기</Button>
          <Button onClick={handleNavigateHome}>메인 화면으로</Button>
        </ButtonContainer>
        <ShareResults onClick={handleShareResults}>
          결과 공유하기
        </ShareResults>
        </Content>
      </Container>
  );
};

const HeaderContainer = styled.div`
  width: 100%;
`;

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 2rem;
`;

const Content = styled.div`
  flex: 1;
  width: 100%;
  max-width: 600px;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const Title = styled.h2`
  color: #6582fc;
  margin-bottom: 2.5rem;
`;

const Score = styled.p`
  font-size: 2rem;
  margin-bottom: 2rem;
`;

const Answers = styled.ul`
  list-style-type: none;
  padding: 0;
  margin-bottom: 2rem;
`;

const AnswerItem = styled.li`
  display: flex;
  align-items: center;
  margin-bottom: 0.5rem;
`;

const QuestionNumber = styled.span`
  margin-right: 0.5rem;
`;

const AnswerResult = styled.span`
  font-weight: bold;
`;

const ButtonContainer = styled.div`
  display: flex;
  gap: 1rem;
  margin-bottom: 2rem;
`;

const Button = styled.button`
  background-color: #6582fc;
  color: white;
  border: none;
  border-radius: 10px;
  padding: 0.5rem 1rem;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
`;

const ShareResults = styled.button`
  background-color: transparent;
  border: none;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
  text-decoration: underline;
  color: #6582fc;
`;

export default QuizResults;