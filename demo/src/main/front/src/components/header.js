import { ReactComponent as logo } from "../images/slang.svg";
import { ReactComponent as profile } from "../images/profile.svg";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";

const Header = () => {
  const navigate = useNavigate();

  const handleNavigate = () => {
    navigate("/home");
  };

  const handleNavigateMyPage = () => {
    navigate("/mypage");
  };
  return (
    <Nav>
      <Logo onClick={handleNavigate} />
      <Profile onClick={handleNavigateMyPage} />
    </Nav>
  );
};

const Logo = styled(logo)`
  width: 5rem;
  margin-left: 3rem;
  cursor: pointer;
`;

const Profile = styled(profile)`
  width: 5rem;
  margin-right: 2rem;
  cursor: pointer;
`;

const Nav = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

export default Header;
