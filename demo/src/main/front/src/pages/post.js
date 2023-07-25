import { styled } from "styled-components";
import Header from "../components/header";
import { useNavigate } from "react-router-dom";

const Post = () => {
  const navigate = useNavigate();

  const handleNavigateHome = () => {
    navigate("/home");
  };

  return (
    <>
      <Header />
      <PostContainer>
        <Title>유행어 등록</Title>
        <P>*부적절한 내용 작성시 관리자에 의해 삭제될 수 있습니다.</P>
        <InputContainer>
          <SubTitle>제목</SubTitle>
          <InputTitle placeholder="등록하고자 하는 유행어를 작성해주세요." />
        </InputContainer>
        <InputContainer>
          <SubTitle>내용</SubTitle>
          <InputContent placeholder="해당 유행어의 의미를 작성해주세요." />
        </InputContainer>
        <Row>
          <PostBtn onClick={handleNavigateHome}>등록하기</PostBtn>
          <ListBtn onClick={handleNavigateHome}>목록으로</ListBtn>
        </Row>
      </PostContainer>
    </>
  );
};

const InputContainer = styled.div``;

const PostContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

const Row = styled.div`
  margin-top: 20px;
  margin-left: 25rem;
`;

const Title = styled.h1`
  margin-bottom: 0;
`;

const P = styled.p`
  color: #7e7e7e;
  font-size: 16px;
  margin-top: 10px;
`;

const SubTitle = styled.h2`
  font-size: 18px;
  align-self: self-start;
`;

const InputTitle = styled.input`
  width: 600px;
  height: 50px;
  font-size: 15px;
  border: 1px solid #c3c3c3;
  border-radius: 14px;
  padding-left: 15px;
`;

const InputContent = styled(InputTitle)`
  height: 200px;
`;

const PostBtn = styled.button`
  background-color: #6582fc;
  width: 100px;
  height: 40px;
  color: white;
  font-weight: 600;
  border-radius: 6px;
  border: none;
  font-size: 18px;
  margin-right: 15px;
  cursor: pointer;
`;

const ListBtn = styled(PostBtn)`
  background-color: #cfd8ff;
  cursor: pointer;
`;

export default Post;
