var empsel_template = `
<div>
<head1></head1>
    <div class="row">
        <div class="col-2 bg-light text-center">
          <br>
          <side :item="1"></side>
        </div>
        <div class="col-10">
            <br>
            <form class="form-inline">
                <label for="name" class="control-label">姓名：</label>
                <input type="text" v-model="condition.name" class="form-control" id="name" placeholder="">&nbsp;&nbsp;
                <label class="control-label" for="cocah">教练名：</label>
                <select v-model="condition.cocah" class="form-control" id="cocah">
                  <option value="">请选择教练</option>
                  <option  v-for="o in cocahs" v-bind:value="o.id">{{o.name}}</option>
                </select>&nbsp;&nbsp;
                <button type="buttom" v-on:click="select" class="btn btn-primary">查询</button>&nbsp;&nbsp;
            </form>
    
            <table class="table table-bordered table-striped text-center" style="margin-top:30px">
                <tr>
                    <td>用户编号</td>
                    <td>姓名</td>
                    <td>电话</td>            
                    <td>邮箱</td>
                    <td>性别</td>
                    <td>职位</td>
                    <td>出生日期</td>
                    <td>备注</td>
                    <td>建档日期</td>
                    <td colspan="2">操作</td>
                </tr>
                <tr v-for="c in customers ">
                    <td>{{c.id}}</td>
                    <td>{{c.name}}</td>
                    <td>{{c.phone}}</td>
                    <td>{{c.email}}</td>
                    <td>{{c.sex}}</td>
                    <td>{{c.party}}</td>
                    <td>{{c.birthday}}</td>
                    <td>{{c.remark}}</td>
                    <td>{{c.create_date}}</td>
                    <td><button type="buttom" v-on:click="edit(c.id)" class="btn btn-outline-primary">修改</button></td>
                    <td><button type="buttom" v-on:click="del(c.id)" class="btn btn-outline-primary">删除</button></td>
                </tr>
             </table>
            <span class="float-left"> 共计：{{customers.length}}人</span>
        </div>
    </div>
<foot1></foot1>
</div>

  `
const empsel = {
  data() {
    var myDate = new Date();
    return {
      condition: { name: '', cocah: ''},
      cocahs: [],
      shareurl: store.state.url,
      customers: [],
      // returnvalue: ''
      
    }
  },
  methods: {
    select() {
      this.$http.get(this.shareurl + 'customer/select?name='+ this.condition.name+'&cocah='+ this.condition.cocah ).then(function (res) {
        // 这里是处理正确的回调
        //console.log(response);
        this.customers = res.body
      }, function (res) {
        // 这里是处理错误的回调
        console.log(res)
      });
    },
    del(id) {
      this.$http.delete(this.shareurl + 'customer/delete/'+id).then(function (res) {
        for (var i = 0; i < this.customers.length; i++) {
          if (id == this.customers[i].id) {
            this.customers.splice(i, 1);
            break;
          }
        }
      }, function (res) {
        // 这里是处理错误的回调
        console.log(res)
      });
    },
    edit(id) {
      router.push({
        path: 'empedit',//进入empedit来编辑
        query: { id: id }
      });
    }
  },
  mounted: function () {  //这里mounted和created生命周期函数区别
    this.$http.get(this.shareurl + 'cocah/select').then(function (res) {
      // 这里是处理正确的回调
      //console.log(response);
      this.cocahs = res.body
    },function (res) {
      // 这里是处理错误的回调
      console.log(res)
    });
  },

  template: empsel_template
  }
