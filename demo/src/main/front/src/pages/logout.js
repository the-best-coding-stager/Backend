import React from 'react';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';

const Logout = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    navigate('/');
  };

  const handleCancel = () => {
    navigate('/mypage');
  };

  return (
    <Container>
      <ConfirmMessage>로그아웃 하시겠어요?</ConfirmMessage>
      <ButtonWrapper>
        <TransparentButton onClick={handleCancel}>취소</TransparentButton>
        <BlueButton onClick={handleLogout}>로그아웃</BlueButton>
      </ButtonWrapper>
    </Container>
  );
};

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
`;

const ConfirmMessage = styled.p`
  font-size: 2rem;
  font-weight: bold;
  margin-bottom: 2rem;
`;

const ButtonWrapper = styled.div`
  display: flex;
  gap: 1rem;
`;

const TransparentButton = styled.button`
  background-color: ${(props) =>
    props.id && props.password ? "#6582fc" : "#E0E6F4"};
  color: ${(props) => (props.id && props.password ? "white" : "#9EACCC")};
  border: none;
  border-radius: 10px;
  padding: 1rem;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
`;

const BlueButton = styled.button`
  background-color: #6582fc;
  color: white;
  border: none;
  border-radius: 10px;
  padding: 1rem;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
`;

export default Logout;