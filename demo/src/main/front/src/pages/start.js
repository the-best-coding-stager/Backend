import styled from "styled-components";
import { ReactComponent as Bg } from "../images/background.svg";
import { ReactComponent as logo } from "../images/slang.svg";
import { useNavigate } from "react-router-dom";

const Start = () => {
  const navigate = useNavigate();

  const handleNavigateLogIn = () => {
    navigate("/login");
  };

  const handleNavigateSignUp = () => {
    navigate("/signup");
  };

  return (
    <>
      <Container>
        <Logo />
        <h2>유행을 따라잡고 싶다면?</h2>
        <P>궁금한 유행어를 검색하고</P>
        <P>퀴즈를 풀어 최신 유행어를 학습해보세요!</P>
        <Btn onClick={handleNavigateSignUp}>바로 시작하기</Btn>
        <Row>
          <P>이미 계정이 있나요?</P>
          <A onClick={handleNavigateLogIn}>로그인</A>
        </Row>
      </Container>
      <BgImg />
    </>
  );
};

export default Start;

const Row = styled.div`
  display: flex;
  margin-top: 2rem;
`;

const A = styled.a`
  cursor: pointer;
  margin-left: 8px;
  color: #6582fc;
  font-weight: 700;
  font-size: 18px;
`;

const Btn = styled.button`
  background-color: #6582fc;
  width: 330px;
  height: 70px;
  border-radius: 40px;
  border: none;
  font-weight: 600;
  color: white;
  font-size: 22px;
  margin-top: 10rem;
  cursor: pointer;
`;

const P = styled.p`
  font-size: 18px;
  margin: 0;
`;

const Container = styled.div`
  margin-top: 22vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

const BgImg = styled(Bg)`
  position: absolute;
  z-index: -1;
  top: 0;
  left: 0;
  right: 0;
  height: 100vh;
  width: 100vw;
  background-size: cover;
  transform: rotate(-3deg) scale(1.1);
`;

const Logo = styled(logo)`
  width: 10rem;
`;
