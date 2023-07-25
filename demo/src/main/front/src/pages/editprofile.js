import styled from 'styled-components';
import { ReactComponent as LogoIcon } from '../images/slang.svg';
import { useNavigate } from 'react-router-dom';

const EditProfile = () => {
  const navigate = useNavigate();

  const handleNavigateHome = () => {
    navigate('/home');
  };

  const handleSaveChanges = () => {
  };

  return (
    <>
      <Logo onClick={handleNavigateHome} />
      <Container>
        <Title>비밀번호 변경</Title>
        <Form>
          <FormItem>
            <Label>기존 비밀번호</Label>
            <Input type="password" />
          </FormItem>
          <FormItem>
            <Label>새 비밀번호</Label>
            <Input type="password" />
            <SP>
              비밀번호는 영문,숫자,특수문자 조합 6~12글자 이내로 작성해주세요.
            </SP>
          </FormItem>
          <FormItem>
            <Label>새 비밀번호 확인</Label>
            <Input type="password" />
          </FormItem>
          <SaveButton onClick={handleSaveChanges}>변경</SaveButton>
        </Form>
      </Container>
    </>
  );
};

const LoginContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
`;

const Logo = styled(LogoIcon)`
  width: 5rem;
  margin-left: 2rem;
  cursor: pointer;
`;

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 2rem;
`;

const Title = styled.h2`
  color: #6582fc;
  margin-bottom: 2.5rem;
`;

const SP = styled.p`
  font-size: 12px;
  margin-top: 10px;
`;

const Form = styled.form`
  display: flex;
  flex-direction: column;
`;

const FormItem = styled.div`
  display: flex;
  flex-direction: column;
  margin-bottom: 1rem;*/
`;

const Label = styled.label`
  font-size: 1rem;
  font-weight: bold;
  margin-bottom: 0.5rem;
`;

const Input = styled.input`
  width: 330px;
  height: 35px;
  border-radius: 40px;
  border: 2.5px solid #6582fc;
  padding-left: 15px;
  font-size: 15px;
`;

const SaveButton = styled.button`
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

export default EditProfile;
