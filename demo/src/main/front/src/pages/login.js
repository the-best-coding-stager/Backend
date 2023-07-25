import styled from "styled-components";
import { ReactComponent as logo } from "../images/slang.svg";
import { useNavigate } from "react-router-dom";
import { useState } from "react";

const Login = () => {
  const [id, setId] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleIdChange = (e) => {
    setId(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleNavigate = () => {
    navigate("/");
  };

  const handleNavigateSignUp = () => {
    navigate("/signup");
  };

  const handleNavigateHome = () => {
    navigate("/home");
  };

  return (
    <>
      <Logo onClick={handleNavigate} />
      <LoginContainer>
        <Container>
          <Title>로그인</Title>
          <Box>
            <P>아이디</P>
            <InputId onChange={handleIdChange} value={id} />
          </Box>
          <Box>
            <P>비밀번호</P>
            <InputPW onChange={handlePasswordChange} value={password} />
          </Box>
          <Row>
            <P>계정이 없으신가요?</P>
            <A onClick={handleNavigateSignUp}>회원가입 하기</A>
          </Row>
          <Btn id={id} password={password} onClick={handleNavigateHome}>
            로그인 하기
          </Btn>
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

const InputId = styled.input`
  width: 330px;
  height: 35px;
  border-radius: 40px;
  border: 2.5px solid #6582fc;
  padding-left: 15px;
  font-size: 15px;
`;

const InputPW = styled(InputId)``;

const Btn = styled.button`
  background-color: ${(props) =>
    props.id && props.password ? "#6582fc" : "#E0E6F4"};
  width: 350px;
  height: 70px;
  border-radius: 22px;
  border: none;
  font-weight: 600;
  color: ${(props) => (props.id && props.password ? "white" : "#9EACCC")};
  font-size: 22px;
  margin-top: 7rem;
  cursor: pointer;
`;

export default Login;
