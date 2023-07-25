import Start from "./pages/start";
import Login from "./pages/login";
import SignUp from "./pages/signup";
import Home from "./pages/home";
import Post from "./pages/post";
import QuizStart from "./pages/quizStart";
import Quiz from "./pages/quiz";
import QuizResult from "./pages/quizResult";
import MyPage from "./pages/mypage";
import Logout from "./pages/logout";
import EditProfile from "./pages/editprofile";
import DeleteAccount from "./pages/deleteaccount";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Start />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/home" element={<Home />} />
        <Route path="/post" element={<Post />} />
        <Route path="/quizstart" element={<QuizStart />} />
        <Route path="/quiz" element={<Quiz />} />
        <Route path="/quizresult" element={<QuizResult />} />
        <Route path="/mypage" element={<MyPage />} />
        <Route path="/logout" element={<Logout />} />
        <Route path="/editprofile" element={<EditProfile />} />
        <Route path="/deleteaccount" element={<DeleteAccount />} />
      </Routes>
    </>
  );
}

export default App;
