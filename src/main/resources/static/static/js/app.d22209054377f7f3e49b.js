webpackJsonp([1],{"4q4r":function(e,t){},NHnr:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=n("7+uW"),r={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},staticRenderFns:[]};var a=n("VU/8")({name:"App"},r,!1,function(e){n("4q4r")},null,null).exports,i=n("zL8q"),s=n.n(i),l=(n("tvR6"),n("/ocq")),u={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-form",{staticClass:"login-container",attrs:{"label-position":"left","label-width":"0px"}},[n("h3",{staticClass:"login_title"},[e._v("东赵家村管综合信息化平台")]),e._v(" "),n("el-form-item",[n("el-input",{attrs:{type:"text","auto-complete":"off",placeholder:"账号"},model:{value:e.loginForm.username,callback:function(t){e.$set(e.loginForm,"username",t)},expression:"loginForm.username"}})],1),e._v(" "),n("el-form-item",[n("el-input",{attrs:{type:"password","auto-complete":"off",placeholder:"密码"},model:{value:e.loginForm.password,callback:function(t){e.$set(e.loginForm,"password",t)},expression:"loginForm.password"}})],1),e._v(" "),n("el-form-item",{staticStyle:{width:"100%"}},[n("el-button",{staticStyle:{width:"100%",background:"#505458",border:"none"},attrs:{type:"primary"},on:{click:e.login}},[e._v("登录")])],1)],1)},staticRenderFns:[]};var c=n("VU/8")({name:"Login",data:function(){return{loginForm:{username:"",password:""},responseResult:[]}},methods:{login:function(){var e=this;this.$axios.post("/login",{username:this.loginForm.username,password:this.loginForm.password}).then(function(t){200===t.data.code&&e.$router.replace({path:"/index"})}).catch(function(e){})}}},u,!1,function(e){n("eabx")},"data-v-5049ba78",null).exports,p={render:function(){var e=this.$createElement;return(this._self._c||e)("div",[this._v("\n  Hello World!\n")])},staticRenderFns:[]};var d=n("VU/8")({name:"Appindex.vue"},p,!1,function(e){n("uNdE")},"data-v-a84d4156",null).exports;o.default.use(l.a);var m=new l.a({mode:"history",routes:[{path:"/login",name:"Login",component:c},{path:"/index",name:"AppIndex",component:d}]}),f=n("mtWM");f.defaults.baseURL="http://localhost:8443/api",o.default.prototype.$axios=f,o.default.config.productionTip=!1,o.default.use(s.a),new o.default({el:"#app",render:function(e){return e(a)},router:m,components:{App:a},template:"<App/>"})},eabx:function(e,t){},tvR6:function(e,t){},uNdE:function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.d22209054377f7f3e49b.js.map