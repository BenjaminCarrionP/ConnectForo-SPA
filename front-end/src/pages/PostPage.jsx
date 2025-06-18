// src/pages/PostPage.jsx

import React, { useState } from "react";
import { useParams } from "react-router-dom";
import Sidebar from "../components/Sidebar";
import SidebarDerecho from "../components/SidebarDerecho";
import Footer from "../components/Footer";
import {
  ArrowUp,
  ArrowDown,
  MessageCircle,
  Award
} from "lucide-react";

const PostPage = () => {
  const { id } = useParams();

  // Mock de publicación basada en el id de la URL
  const [post] = useState({
    id: parseInt(id, 10),
    foroId: 1,
    title: `Título de la publicación #${id}`,
    imageUrl: "/imgs/placeholder.jpg",
    content: `Este es el contenido completo de la publicación #${id}. Aquí puedes ver todo el texto sin límites de líneas.`,
    upvotes: 23,
    downvotes: 2,
    comments: 5
  });

  const handleUpvote = () => {
    // TODO: lógica de upvote
  };
  const handleDownvote = () => {
    // TODO: lógica de downvote
  };
  const handleComment = () => {
    // TODO: scroll hasta sección de comentarios o abrir modal
  };
  const handleReward = () => {
    // TODO: llamada al microservicio de reputación
  };

  return (
    <div className="min-h-screen bg-neutral-900 text-white">
      {/* Cabecera de la publicación */}
      <div className="px-6 py-4 border-b border-gray-700">
        <h1 className="text-3xl font-bold">{post.title}</h1>
      </div>

      <div className="flex px-6 py-8 gap-6">
        {/* Sidebar izquierdo */}
        <Sidebar />

        {/* Contenido principal */}
        <main className="flex-1 space-y-6">
          {/* Imagen */}
          {post.imageUrl && (
            <img
              src={post.imageUrl}
              alt={post.title}
              className="w-full object-cover rounded-lg"
            />
          )}

          {/* Texto completo */}
          <div className="prose prose-invert">
            <p>{post.content}</p>
          </div>

          {/* Barra de acciones */}
          <div className="flex items-center space-x-6">
            <button
              onClick={handleUpvote}
              className="flex items-center space-x-1 text-gray-400 hover:text-green-500"
            >
              <ArrowUp size={18} />
              <span>{post.upvotes}</span>
            </button>
            <button
              onClick={handleDownvote}
              className="flex items-center space-x-1 text-gray-400 hover:text-red-500"
            >
              <ArrowDown size={18} />
              <span>{post.downvotes}</span>
            </button>
            <button
              onClick={handleComment}
              className="flex items-center space-x-1 text-gray-400 hover:text-blue-500"
            >
              <MessageCircle size={18} />
              <span>{post.comments}</span>
            </button>
            <button
              onClick={handleReward}
              className="flex items-center space-x-1 text-gray-400 hover:text-yellow-500"
            >
              <Award size={18} />
              <span>Premiar</span>
            </button>
          </div>

          {/* Aquí podrías mapear una sección de comentarios reales */}
        </main>

        {/* Sidebar derecho + Footer */}
        <aside className="w-64 sticky top-24 flex flex-col gap-6">
          <SidebarDerecho />
          <Footer />
        </aside>
      </div>
    </div>
  );
};

export default PostPage;
