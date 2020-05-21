function frmChk(join){
    frm=document.getElementById('join');
    //frm=document.member
    
    if(frm.mid.value.length<6 || frm.mid.value.length>15){
    alert('아이디는 6-15자리로 입력하세요')
    frm.mid.focus();
    return false;
    }
    if(frm.mname.value.length<1){
    alert('이름은 필수입니다')
    frm.mname.focus();
    return false;
    }
    if(frm.mpwd.value.length<8 || frm.mpwd.value.length>30){
    alert('비밀번호는 8-30자리로 입력하세요')
    frm.mpwd.focus();
    return false;
    }
    if(frm.mpwd.value!=frm.mpwd2.value){
    alert('비밀번호가 일치 하지 않습니다')
    frm.mpwd2.value='';
    frm.mpwd2.focus();
    return false;
    }
    if(frm.mbd.value.length<1){
    alert('생일을 입력하세요')
    frm.mbd.focus();
    return false;
    }
    if(frm.memail.value.length<1){
    alert("이메일을 입력하세요")
    frm.memail.focus();
    return false;
    }
    if(frm.memail2.value.selectedIndex<1){
    alert("이메일을 선택하세요")
    frm.memail2.focus();
    return false;
    }
    //alert(document.getElementById('mhp').value);
    //alert(document.getElementById('mhp').selectedIndex);
    //alert(frm.mhp.value);
    if(frm.mhp.selectedIndex<1){
    alert("핸드폰번호를 선택하세요")
    return false;
    }
    if(frm.mhp1.value.length<1){
    alert("중간 핸드폰번호 4자리를 입력하세요")
    return false;
    }
    if(frm.mhp2.value.length<1){
    alert("마지막 핸드폰번호 4자리를 입력하세요")
    return false;
    }
    if(confirm("가입하시겠습니까?")){
    frm.submit(join)
    }
    var o = document.getElementById("joinFrm");
    o.src = "join.do?";
}

function frmChk1(myinfo){
	frm=document.getElementById('myinfo');
	if(frm.mpwd2.value.length<1){
	alert('비밀번호 확인을 입력해주세요')
	frm.mpwd2.focus();
    return false;
	}
	if(frm.mpwd.value!=frm.mpwd2.value){
    alert('비밀번호가 일치 하지 않습니다')
    frm.mpwd2.value='';
    frm.mpwd2.focus();
    return false;
    }
	$("form[id=='myinfo']").submit()
//	var o = document.getElementById("myinfoFrm");
//    o.src = "myinfoUpdate.do?";
}
    