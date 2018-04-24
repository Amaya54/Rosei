var click=0;

function press(id1){
	id1.id="press";	
}

function release(id1){
	id1.id="submit";
}

function submit1(){
	chng();
document.login.submit();

}

function chng(){
	var x=document.getElementById('img1');
	x.id="img3";
	var y=document.getElementById('img2');
	y.id="img4";
	var z=document.getElementById('login');
	z.style.visibility="hidden";
	document.getElementById('back').style.visibility="visible";
}






















