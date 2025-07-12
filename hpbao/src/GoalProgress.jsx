import React from "react";
import "./GoalProgress.css";

const GoalProgress = ({ progress, goalName }) => {
    return (
        <div className="goal-progress">
            <div className="circle-progress">
                <svg className="progress-ring" width="100" height="100">
                    <circle
                        className="progress-ring__circle"
                        stroke="tomato"
                        strokeWidth="6"
                        fill="transparent"
                        r="45"
                        cx="50"
                        cy="50"
                    />
                    <circle
                        className="progress-ring__circle"
                        stroke="orange"
                        strokeWidth="6"
                        fill="transparent"
                        r="45"
                        cx="50"
                        cy="50"
                        style={{
                            strokeDasharray: `${2 * Math.PI * 45} ${2 * Math.PI * 45}`,
                            strokeDashoffset: `${2 * Math.PI * 45 * ((100 - progress) / 100)}`
                        }}
                    />
                </svg>
                <div className="progress-text">{`${progress}%`}</div>
            </div>
            <div className="goal-name">{goalName}</div>
        </div>
    );
};

export default GoalProgress;
