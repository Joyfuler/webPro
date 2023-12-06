const express = require('express'); // express 라이브러리 첨부
const app = express();

const url = "mongodb+srv://jpju98:tLqtZBSdnKTwO2RR@cluster1.txh2hey.mongodb.net/?retryWrites=true&w=majority"
const MongoClient = require('mongodb').MongoClient;
var db;
// 몽고DB 연결 후 실행할 콜백함수를 적는다.
MongoClient.connect(url, function(error, client){
    if (error){
        return console.log(error);
        // 에러 발생시에는 console.log로 메시지 출력, 없다면 정상 연결.
    }
    db = client.db('toDoApp'); //데이터베이스 명
    // insert시는 json 형식으로 넣을 것. _id는 primary key
    // db연결 후 서버에 연결하도록 함.
    // app.listen(서버 띄울 포트번호, 서버 연동 후 실행할 콜백 함수)
    app.listen(8090, function(){
        console.log('8090서버 띄움');
    });  
});

// 태그를 직접 입력하기보다는 일반적으로 html 파일 (css/js등이 포함된)을 추가하며
// 이 경우에는 sendFile을 사용한다.
app.use(express.static('public'));
app.set('view engine', 'ejs');
//view단에서 보여줄 확장자는 ejs로.
app.get('/', (req, res) => {
    // response.sendFile(__dirname + '/index.html');
    // __dirname은 현재 폴더를 의미. index.html이 뷰단으로 변경
    res.render('index.ejs'); // ejs는 반드시 views 폴더 아래에 둘 것.
});

app.get('/write', (req,res) => {
    res.render('write.ejs');
});

app.use(express.urlencoded({extended:true}));
app.post('/write', (req, res) => {
    // 1. counter에서 post_sq를 가져옴. (시퀀스역할)
    db.collection('counter').findOne({name:'현재시퀀스'}, (err, result) => {
        if (err){
            console.log(err);
        }
        console.log(result); // where name = '현재시퀀스' 한 결과
        var post_sq = result.post_sq;
        db.collection('post').insertOne({_id: post_sq +1, title : req.body.title,
        date: req.body.date}, (err, result) => {
            if (err){
                return console.log(err);
            }
            // 성공했다면 post_sq 값을 1 증가
            // updateOne({조건}, {수정내용}, 콜백함수)
            // (or) updateOne({조건}, {$inc:{증가분}}, 콜백함수)
            // updateOne({조건}, {$set : {수정내용}}, 콜백함수)
            db.collection('counter').updateOne({name:'현재시퀀스'}, 
                                               {$set : {post_sq: post_sq+1}},
                                               function(err, result){
                if (err){
                    return console.log(err);
                }
                res.redirect('/list');
            });            
        });
    }); 
    // 2. {_id: post_sq +1, title : req.body.title, date : req.body.date} 형식으로 입력.
    // 3. counter에 있는 post_sq의 값을 +1 해준다.
    console.log('할 일 :' + req.body.title); // body 내의 title 패러미터
    console.log("마감일 :" + req.body.date);
    console.log('넘어온 파라미터들:', req.body);
    // 전송 완료된 데이터를 mongoDB에 insert    
});

app.get('/list', (req,res) => {
    // post collection에서 저장된 데이터를 리스트로 가져와 view단 (ejs)출력
    db.collection('post').find().toArray(function(error, result){
        if (error){
            return console.log(error);
        } // 에러인 경우는 콘솔에 메시지 출력
        res.render('list.ejs', {posts:result});
    }); 
    // findOne은 한개, find()는 전체. 배열로 가져오기
    //res.sendFile(__dirname+'/list.html');
});