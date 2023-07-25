import styled from "styled-components";
import { ReactComponent as logo } from "../images/slang.svg";
import { useNavigate } from "react-router-dom";
import Man from "../images/man.png";

const QuizStart = () => {
  const navigate = useNavigate();

  const handleNavigateHome = () => {
    navigate("/home");
  };

  const handleNavigateQuiz = () => {
    navigate("/quiz");
  };

  return (
    <>
      <Logo onClick={handleNavigateHome} />
      <Container>
        <Title>유행어 퀴즈</Title>
        <P>내가 유행어를 얼마나 잘 아는지 확인해보세요!</P>
        <Icon src={Man} />
        <Btn onClick={handleNavigateQuiz}>시작하기</Btn>
      </Container>
    </>
  );
};

const Icon = styled.img`
  height: 22rem;
`;

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const P = styled.p`
  font-size: 20px;
  margin-top: 8px;
`;

const Logo = styled(logo)`
  width: 5rem;
  margin-left: 2rem;
  cursor: pointer;
`;

const Title = styled.h1`
  color: #6582fc;
  font-size: 55px;
  margin-bottom: 0;
`;

const Btn = styled.button`
  background-color: #6582fc;
  color: white;
  width: 230px;
  height: 60px;
  border-radius: 12px;
  border: none;
  font-size: 20px;
  font-weight: 600;
  cursor: pointer;
  margin-top: 2rem;
`;

export default QuizStart;
