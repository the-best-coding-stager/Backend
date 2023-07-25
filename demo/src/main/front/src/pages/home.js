import SideBar from "../components/sidebar";
import Header from "../components/header";
import { ReactComponent as search } from "../images/search.svg";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";

const Home = () => {
  const navigate = useNavigate();

  const handleNavigateQuiz = () => {
    navigate("/quizstart");
  };

  const handleNavigatePost = () => {
    navigate("/post");
  };

  return (
    <Container>
      <Header />
      <RowContainer>
        <SideBar />
        <SearchContainer>
          <Row>
            <SearchBar placeholder="궁금한 키워드를 검색해보세요."></SearchBar>
            <SearchBtn />
          </Row>
          <Table>
            <thead>
              <tr>
                <Th>번호 </Th> <Th>제목</Th> <Th>작성일</Th> <Th>좋아요 수</Th>
              </tr>
            </thead>
            <tbody>
              {/* 나중에 컴포넌트화하기 */}
              <tr>
                <Td>1</Td>
                <Td>유행어1</Td>
                <Td>2023/07/05</Td>
                <Td>2</Td>
              </tr>
              <tr>
                <Td>1</Td>
                <Td>유행어1</Td>
                <Td>2023/07/05</Td>
                <Td>2</Td>
              </tr>
              <tr>
                <Td>1</Td>
                <Td>유행어1</Td>
                <Td>2023/07/05</Td>
                <Td>2</Td>
              </tr>
              <tr>
                <Td>1</Td>
                <Td>유행어1</Td>
                <Td>2023/07/05</Td>
                <Td>2</Td>
              </tr>
              <tr>
                <Td>1</Td>
                <Td>유행어1</Td>
                <Td>2023/07/05</Td>
                <Td>2</Td>
              </tr>
              <tr>
                <Td>1</Td>
                <Td>유행어1</Td>
                <Td>2023/07/05</Td>
                <Td>2</Td>
              </tr>
              <tr>
                <Td>1</Td>
                <Td>유행어1</Td>
                <Td>2023/07/05</Td>
                <Td>2</Td>
              </tr>
              <tr>
                <Td>1</Td>
                <Td>유행어1</Td>
                <Td>2023/07/05</Td>
                <Td>2</Td>
              </tr>
            </tbody>
          </Table>
          <PostBtn onClick={handleNavigatePost}>등록</PostBtn>
        </SearchContainer>
        <QuizBtn onClick={handleNavigateQuiz}>최신 유행어 퀴즈보기</QuizBtn>
      </RowContainer>
    </Container>
  );
};

const QuizBtn = styled.button`
  align-self: end;
  background-color: #6582fc;
  width: 180px;
  height: 50px;
  color: white;
  border-radius: 12px;
  border: none;
  font-size: 16px;
  font-weight: 600;
  margin-left: 3rem;
  cursor: pointer;
`;

const PostBtn = styled.button`
  background-color: #cfd8ff;
  border-radius: 7px;
  border: none;
  width: 72px;
  height: 33px;
  font-size: 15px;
  margin-top: 13px;
  margin-left: 90%;
  cursor: pointer;
`;

const Table = styled.table`
  margin-top: 3rem;
  width: 100%;
  border-top: 1px solid #7e7e7e;
  border-collapse: collapse;
`;

const Th = styled.th`
  border-bottom: 1px solid #7e7e7e;
  padding: 10px;
`;

const Td = styled(Th)`
  font-weight: 400;
  font-size: 15px;
`;

const RowContainer = styled.div`
  display: flex;
  align-items: flex-start;
  margin-top: 10px;
  width: 100vw;
`;

const SearchBar = styled.input`
  width: 450px;
  height: 50px;
  border-radius: 40px;
  border: 2.5px solid #6582fc;
  padding-left: 1rem;
  font-size: 15px;
  margin-right: 1rem;
`;

const Row = styled.div`
  display: flex;
  align-items: center;
  margin-left: 6rem;
`;

const SearchBtn = styled(search)``;

const Container = styled.div`
  display: flex;
  flex-direction: column;
`;

const SearchContainer = styled(Container)`
  width: 55%;
  margin-left: 3rem;
`;

export default Home;
