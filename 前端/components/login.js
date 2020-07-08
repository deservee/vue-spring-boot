﻿var login_template = `
<div style="width:50%;padding-left:20px;">
            <h2 style="text-align:center;">欢迎登录升龙健身房</h2>
            <div class="form-group">
                <label for="username">用户名:</label>&nbsp;
                <input type="text" v-model="username" class="form-control" id="username">
            </div>
            <div class="form-group">
                <label for="pwd">密码:</label>&nbsp;
                <input type="password" v-model="pwd" class="form-control" id="pwd">
            </div>
            <input type="checkbox" name="remember">记住我<br/>
            <div class="form-group">
                <button v-on:click="login_1" class="btn btn-primary">登录</button>
            </div>
            <h6>{{returnvalue}}</h6>

        <br>
        <br>
</div>
    `
const login = {
    data() {
        return {
            users: [],
            shareurl: store.state.url,
            isedit: false,
            username:'',
            pwd:'',
            returnvalue:''
        }
    },
    methods: {
        login_1() {
            //credentials: true 允许携带cookie
            this.$http.post(this.shareurl + 'login?username=' + this.username + '&password=' + this.pwd).then(function (res) {
                // 这里是处理正确的回调
                console.log(res);
                var temps = res.body;
                if (temps.status == 'success') {
                    console.log("645645");
                    this.returnvalue = 'success';
                    this.$router.push('/empsel');
                 //   this.user = false;
                    //     this.username = temps.msg;
                } else {
                         this.returnvalue = res.body.msg;
                }
            }, function (res) {
                // 这里是处理错误的回调
                console.log(res)
            });
        }
    },
    template: login_template
}
    
        
