function addToMypage(action){
	document.addForm.action = action;
	document.addForm.submit();
	alert("단어가 마이페이지에 추가되었습니다!");
}

function removeFromMypage(action){
	document.removeForm.action = action;
	document.removeForm.submit();
	window.location.reload();
}

function clearMypage(){
	document.clearForm.submit();
	window.location.reload();
}

function deleteConfirm(id){
	if (confirm("삭제합니다!!") == true) location.href = "./delete?id=" + id;
	else return;
}