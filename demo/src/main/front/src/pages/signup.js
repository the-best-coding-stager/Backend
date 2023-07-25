import styled from "styled-components";
import { ReactComponent as logo } from "../images/slang.svg";
import { useNavigate } from "react-router-dom";

const SignUp = () => {
  const navigate = useNavigate();

  const handleNavigate = () => {
    navigate("/login");
  };

  const handleNavigateHome = () => {
    navigate("/");
  };

  return (
    <>
      <Logo onClick={handleNavigateHome} />
      <LoginContainer>
        <Container>
          <Title>회원가입</Title>
          <Box>
            <P>아이디</P>
            <Input />
            <SP>아이디는 영문,숫자 조합 4~10글자 이내로 작성해주세요.</SP>
          </Box>
          <Box>
            <P>비밀번호</P>
            <Input />
            <SP>
              비밀번호는 영문,숫자,특수문자 조합 6~12글자 이내로 작성해주세요.
            </SP>
          </Box>
          <Box>
            <P>비밀번호 재입력</P>
            <Input />
          </Box>
          <Row>
            <P>이미 계정이 있으신가요?</P>
            <A onClick={handleNavigate}>로그인 하기</A>
          </Row>
          <Btn>회원가입 하기</Btn>
        </Container>
      </LoginContainer>
    </>
  );
};

const LoginContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
`;

const SP = styled.p`
  font-size: 12px;
  margin-top: 10px;
`;

const A = styled.a`
  margin-left: 8px;
  color: #6582fc;
  font-weight: 700;
  cursor: pointer;
`;

const Row = styled.div`
  display: flex;
  align-items: center;
  align-self: flex-start;
`;

const Box = styled.div``;

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 21rem;
`;

const Logo = styled(logo)`
  width: 5rem;
  margin-left: 2rem;
  cursor: pointer;
`;

const Title = styled.h2`
  color: #6582fc;
  margin-bottom: 2.5rem;
`;

const P = styled.p`
  align-self: flex-start;
`;

const Input = styled.input`
  width: 330px;
  height: 35px;
  border-radius: 40px;
  border: 2.5px solid #6582fc;
  padding-left: 15px;
  font-size: 15px;
`;

const Btn = styled.button`
  background-color: #6582fc;
  width: 350px;
  height: 70px;
  border-radius: 22px;
  border: none;
  font-weight: 600;
  color: white;
  font-size: 22px;
  margin-top: 2rem;
  cursor: pointer;
`;

export default SignUp;
