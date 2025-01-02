




과제 타이틀 "Java(Kotlin) Backend Engineer" 을
코틀린 한정으로 잘 못 보고 코틀린 스택으로 작업했습니다.

개인 사정으로 시간을 많이 내지 못해 3일 정도 작업 공수 사용되었고
코틀린 스택을 다루어 본 것이 처음이라 요건에 기준들을 대부분 맞추지 못했습니다.

코디 서비스를 대규모/실시간 조회 위주 트랜잭션이라 가정하고
조회와 추가/변경/삭제 각각 분리하여 배치처리 포함하는 CQRS 잡으려다
시간을 너무 써 구현을 많이 못 하였는데 설계한 데이터단도 구현물에 반영되진 못했습니다.

아래는 구현된 부분까지의 간략한 요약 정도입니다.





추가 (예시) :

curl -X POST
&nbsp;&nbsp;-F name=A
&nbsp;&nbsp;-F total=37700
&nbsp;&nbsp;-F cat1=11200
&nbsp;&nbsp;-F cat2=5500
&nbsp;&nbsp;-F cat3=4200
&nbsp;&nbsp;-F cat4=9000
&nbsp;&nbsp;-F cat5=2000
&nbsp;&nbsp;-F cat6=1700
&nbsp;&nbsp;-F cat7=1800
&nbsp;&nbsp;-F cat8=2300
&nbsp;&nbsp;-v http://localhost:8080/cody/putBrand



조회 :  http://127.0.0.1:8080/cody/getBrandList



구현 1 :  http://127.0.0.1:8080/cody/getExam1List

구현 2 :  http://127.0.0.1:8080/cody/getExam2List



구현 3 :  http://127.0.0.1:8080/cody/getExam3List/{catNo}

기 입력해둔 {catNo} 는 1~8 로 상의~액세서리 에 해당하는 필드 순서 번호입니다.



삭제 :  curl -X POST –F id={id} -v http://localhost:8080/cody/delBrand

{id} 는 조회에서 확인할 수 있는 각 레코드 건의 id 필드 값입니다.



화면을 못 붙혀서 JSON 데이터 넘어오는 것으로 확인할 수 있습니다.




