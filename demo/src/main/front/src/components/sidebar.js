import styled from "styled-components";

const SideBar = () => {
  return (
    <Bar>
      <Title>메뉴</Title>
      <Title>🔥 최신 유행어</Title>
      {/* 최신 유행어 리스트 받아와 넣기 */}
      <Ul>
        <Li>1. 추구미</Li>
        <Li>2. 바퀴벌레 밈</Li>
        <Li>3. 오우예 씨몬</Li>
        <Li>4. 알새우칩</Li>
      </Ul>
      {/* 인기 검색어 리스트 받아와 넣기 */}
      <Title>⭐️ 인기 검색어</Title>
      <Ul>
        <Li>1. 추구미</Li>
        <Li>2. 바퀴벌레 밈</Li>
        <Li>3. 오우예 씨몬</Li>
        <Li>4. 알새우칩</Li>
      </Ul>
    </Bar>
  );
};

const Ul = styled.ul`
  margin: 0;
  padding: 0;
`;

const Li = styled.li`
  list-style: none;
  margin-bottom: 8px;
`;

const Title = styled.h2`
  font-size: 18px;
`;

const Bar = styled.div`
  display: flex;
  flex-direction: column;
  width: 260px;
  height: 680px;
  margin-left: 2rem;
  background-color: #cfd8ff;
  border-radius: 33px;
  border: none;
  padding-left: 20px;
  padding-top: 10px;
`;

export default SideBar;
