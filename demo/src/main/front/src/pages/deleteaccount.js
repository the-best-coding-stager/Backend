import React from 'react';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';

const Logout = () => {
  const navigate = useNavigate();

  const handleDeleteAccount = () => {
    navigate('/');
  };

  const handleCancel = () => {
    navigate('/mypage');
  };

  return (
    <Container>
      <Description>회원 탈퇴 시 저장된 퀴즈 결과 및 좋아요 목록이 사라집니다.</Description>
      <ConfirmMessage>그래도 탈퇴 하시겠어요?</ConfirmMessage>
      <ButtonWrapper>
        <TransparentButton onClick={handleDeleteAccount}>탈퇴 할래요</TransparentButton>
        <BlueButton onClick={handleCancel}>탈퇴 안 할래요</BlueButton>
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

const Description = styled.p`
  font-size: 1.2rem;
  margin-bottom: 1rem;
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