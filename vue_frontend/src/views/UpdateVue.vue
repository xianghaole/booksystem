<template>
    <div>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" style="width:40%">
            <el-form-item label="图书编号" >
                <el-input v-model="ruleForm.id" readonly></el-input>
            </el-form-item>
            <el-form-item label="图书名称" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="作者" prop="author">
                <el-input v-model="ruleForm.author"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        data() {
            return {
                ruleForm: {
                    id:'',
                    name: '',
                    author: ''
                },
                rules: {
                    name: [
                        { required: true, message: '图书名称不能为空', trigger: 'blur' },
                    ],
                    author: [
                        { required: true, message: '作者不能为空', trigger: 'blur' },
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.put("http://121.41.97.153:8888/book/update",this.ruleForm).then((res)=>{
                            this.$message({
                                message: '恭喜你，修改成功',
                                type: 'success'
                            });
                            this.$router.push('/BookManager')
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        },
        created(){
            axios.get("http://121.41.97.153:8888/book/findById/"+this.$route.query.id).then((res)=>{
                this.ruleForm = res.data.data
            })
        }
    }
</script>

<style>

</style>
