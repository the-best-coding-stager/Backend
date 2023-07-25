import React from 'react';
import { useState } from "react";
import styled from 'styled-components';
import { ReactComponent as LogoIcon } from "../images/slang.svg";
import { ReactComponent as ProfileIcon } from "../images/profile.svg";
import { useNavigate } from "react-router-dom";

 
const MyPage = ({ userId }) => {

    const [likedWords, setLikedWords] = useState([
      { word: '추구미미', liked: true },
      { word: '중꺽마', liked: true },
      { word: '알새우칩', liked: false },
      { word: '머선129', liked: true },
    ]);
  
    const handleLikeToggle = (index) => {
      setLikedWords((prevLikedWords) => {
        const updatedLikedWords = [...prevLikedWords];
        updatedLikedWords[index].liked = !updatedLikedWords[index].liked;
        return updatedLikedWords;
      });
    };

    const navigate = useNavigate();

    const handleNavigate = () => {
        navigate("/");
    };

    const handleNavigateHome = () => {
        navigate("/home");
    };    
  
    const handleNavigateEditProfile = () => {
        navigate("/editprofile");
    };
  
    const handleLogout = () => {
        navigate("/logout");
    };
  
    const handleDeleteAccount = () => {
        navigate("/deleteaccount");
    };
  
    return (
      <>
        <Logo onClick={handleNavigateHome} />
        <Container>
          <Title>마이페이지</Title>
              <ProfileIcon />
            <UserId>{userId}</UserId>
          <Section>
            <SectionTitle>내가 좋아하는 유행어</SectionTitle>
            <WordList>
              {likedWords.map((likedWord, index) => (
                <WordItem key={index}>
                  <Word>{likedWord.word}</Word>
                  <LikeButton liked={likedWord.liked} onClick={() => handleLikeToggle(index)}>
                    <Heart liked={likedWord.liked} xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                      <path d="M12 21.35L6.28 17.77C2.74 14.76 1 12.73 1 9.5 1 6.42 3.42 4 6.5 4c1.74 0 3.41.81 4.5 2.09C12.59 4.81 14.26 4 16 4c3.08 0 5.5 2.42 5.5 5.5 0 3.23-1.74 5.26-5.28 8.27L12 21.35z" />
                    </Heart>
                  </LikeButton>
                </WordItem>
              ))}
            </WordList>
          </Section>
          <ButtonWrapper>
          <Button onClick={handleNavigateEditProfile}>비밀번호 변경</Button>
          <Button onClick={handleLogout}>로그아웃</Button>
          <Button onClick={handleDeleteAccount}>탈퇴하기</Button>
          </ButtonWrapper>
        </Container>
      </>
    );
  };
  
  const Logo = styled(LogoIcon)`
    width: 5rem;
    margin-left: 3rem;
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
  
  const UserId = styled.span`
    font-size: 1.2rem;
    font-weight: bold;
  `;
  
  const Section = styled.div`
    margin-top: 2rem;
  `;
  
  const SectionTitle = styled.h3`
    font-size: 1.2rem;
    font-weight: bold;
  `;
  
  const WordList = styled.ul`
    list-style-type: none;
    padding: 0;
    margin: 1rem 0;
`;

  const WordItem = styled.li`
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 0.5rem;
`;

  const Word = styled.span`
    font-size: 1.1rem;
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
    margin-top: 1rem;
`;

const ButtonWrapper = styled.div`
  display: flex;
  gap: 1rem;
  margin-top: 1rem;
`;

const LikeButton = styled.button`
  background-color: transparent;
  border: none;
  cursor: pointer;
  svg {
    fill: ${(props) => (props.liked ? '#e74c3c' : 'none')};
    transition: fill 0.3s;
  }
  &:hover svg {
    fill: ${(props) => (props.liked ? '#c0392b' : '#e74c3c')};
  }
`;

const Heart = styled.svg`
  width: 1rem;
  height: 1rem;
  fill: ${props => (props.liked ? "#e74c3c" : "none")};
  stroke: ${props => (props.liked ? "#e74c3c" : "#000")}; /* Added stroke color */
  stroke-width: 1.5px; /* Added stroke width */
  transition: fill 0.3s;

  &:hover {
    fill: ${props => (props.liked ? "#c0392b" : "#e74c3c")};
    stroke: ${props => (props.liked ? "#c0392b" : "#000")}; /* Added stroke color on hover */
  }
`;

export default MyPage;