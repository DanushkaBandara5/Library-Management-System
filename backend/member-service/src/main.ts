import express from 'express';
import env from 'dotenv';


env.config();
const app =express();

app.listen(process.env.SERVER_PORT,()=>console.log(`sever Started using port ${process.env.SERVER_PORT}`))